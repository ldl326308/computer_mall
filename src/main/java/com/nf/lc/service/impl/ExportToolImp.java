package com.nf.lc.service.impl;

import com.nf.lc.dao.AdministratorsMapper;
import com.nf.lc.dao.UserMapper;
import com.nf.lc.entity.Administrators;
import com.nf.lc.entity.User;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.ExportTool;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ExportToolImp implements ExportTool {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdministratorsMapper administratorsMapper;

    @Override
    public byte[] exportUser(int userState, int start, int end) throws EmptyException, FailureException {
        List<User> users = userMapper.exportUser(userState, (start -1) * 10, (end - start) * 10);
        if(users.size() == 0){  //没有数据，不执行导出操作
            throw new EmptyException("没有数据可以导出！");
        }

        //执行导出操作
        //创建Excel表格
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作铺
        XSSFSheet sheet = workbook.createSheet("user");
        //第一行头部
        XSSFRow row = sheet.createRow(0);  //创建第一行
        String[] header = new String[]{"编号","登入账号","用户昵称","用户状态","创建时间","头像图片路径"};
        for (int i = 0; i < header.length; i++) {
            row.createCell(i).setCellValue(header[i]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");

        //数据写入
        int i = 1;
        for (User user : users) {
            XSSFRow dataRow = sheet.createRow(i);  //创建行
            dataRow.createCell(0).setCellValue(user.getUserId());
            dataRow.createCell(1).setCellValue(user.getUserAccountNumber());
            dataRow.createCell(2).setCellValue(user.getUserNickname());
            dataRow.createCell(3).setCellValue(user.getUserState()==1?"正常":"冻结");
            dataRow.createCell(4).setCellValue(sdf.format(user.getUserCreateTime()));
            dataRow.createCell(5).setCellValue(user.getUserHeadPortrait());
            i++;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new FailureException("导出失败了！");
        }
    }

    @Override
    public byte[] exportAdmin(int adminState, int start, int end) throws FailureException, EmptyException {
        List<Administrators> admins = administratorsMapper.exportAdmin(adminState, (start - 1) * 10, (end - start) * 10);
        if(admins.size() == 0){  //没有数据，不执行导出操作
            throw new EmptyException("没有数据可以导出！");
        }

        //执行导出操作
        //创建Excel表格
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作铺
        XSSFSheet sheet = workbook.createSheet("admin");
        //第一行头部
        XSSFRow row = sheet.createRow(0);  //创建第一行
        String[] header = new String[]{"编号","身份证号","登入账号","性别","年龄","管理用户权限","管理商品权限","最高权限","状态"};
        for (int i = 0; i < header.length; i++) {
            row.createCell(i).setCellValue(header[i]);
        }

        //数据写入
        int i = 1;
        for (Administrators admin : admins) {
            XSSFRow dataRow = sheet.createRow(i);  //创建行
            dataRow.createCell(0).setCellValue(admin.getAdminId());
            dataRow.createCell(1).setCellValue(admin.getAdminIdNumber());
            dataRow.createCell(2).setCellValue(admin.getAdminAccountNumber());
            dataRow.createCell(3).setCellValue(admin.getAdminSexual());
            dataRow.createCell(4).setCellValue(admin.getAdminAge());
            dataRow.createCell(5).setCellValue(admin.getAdminPowerUser() == 0 ? "无":"有");
            dataRow.createCell(6).setCellValue(admin.getAdminPowerComputer() == 0 ? "无":"有");
            dataRow.createCell(7).setCellValue(admin.getAdminPowerSuperme() == 0 ? "无":"有");
            dataRow.createCell(8).setCellValue(admin.getAdminState() == 0 ? "正常":"冻结");
            i++;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new FailureException("导出失败了！");
        }
    }
}

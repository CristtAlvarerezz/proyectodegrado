package com.example.lambda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

class sync_worpress {

    boolean flag;
    String dat[] = new String[13];

    public String [] syncuser(String User, String Table){

        String sql = "SELECT*FROM wp_users WHERE " + Table + "='" + User + "'";
        System.out.print(sql);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            flag = false;

            while (rs.next()) {
                flag = true;
                dat[0] = rs.getString(1);
                dat[1] = rs.getString(2);
                dat[2] = rs.getString(3);
                dat[3] = rs.getString(4);
                dat[4] = rs.getString(5);
                dat[5] = rs.getString(6);
                dat[6] = rs.getString(7);
                dat[7] = rs.getString(8);
                dat[8] = rs.getString(9);
                dat[9] = rs.getString(10);
                dat[10] = rs.getString(11);
                dat[11] = rs.getString(12);
                dat[12]=rs.getString(13);
            }
            if (flag == false) {
                for (int i = 0; i <= 12; i++) {
                    dat[i] = "";
                }
            }
        } catch (SQLException e) {
            System.err.print(e);
        }
        return dat;
    }
    connection cc= new connection();
    Connection cn=cc.database_connection("192.168.0.22/wordpress");
}
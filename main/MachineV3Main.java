package main;

import Db.MysqlConnection;
import view.MachineUserView;

import java.sql.Connection;

public class MachineV3Main {


    public static void main(String[] args) {
        MachineUserView mv = new MachineUserView();
        mv.viewMain();

    }
}

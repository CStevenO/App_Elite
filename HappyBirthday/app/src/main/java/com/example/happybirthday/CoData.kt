package com.example.happybirthday

import android.annotation.SuppressLint
import android.os.StrictMode
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


class ConnectionHelper {
    var IP: String? = null
    var DB: String? = null
    var DBUsername: String? = null
    var DBPassword: String? = null

    @SuppressLint("NewApi")
    fun connection(): Connection? {
        IP = "ELT-DB13-FCA.ELITE.LOCAL:1433"
        DB = "ELITE"
        DBUsername = "mtto_invernaderos"
        DBPassword = "rosal714"
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var connection: Connection? = null
        var ConnectionURL: String? = null
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            ConnectionURL = "jdbc:jtds:sqlserver://$IP;databaseName=$DB;user=$DBUsername;password=$DBPassword"
            connection = DriverManager.getConnection(ConnectionURL)
        } catch (e: SQLException) {
            e.message
        } catch (e: ClassNotFoundException) {
            e.message
        } catch (ex: Exception) {
            ex.message
        }
        return connection
    }
}
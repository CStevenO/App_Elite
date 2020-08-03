package com.example.happybirthday

import android.widget.Toast
import java.sql.Connection
import java.util.*


class GetData {
    var connection: Connection? = null
    var ConnectionResult: String? = ""
    var isSuccess = false
    val data: List<Map<String?, String?>?>
        get() {
            var data: MutableList<Map<String?, String?>?>? = null
            data = ArrayList()
            try {
                val connectionHelper = ConnectionHelper()
                connection = connectionHelper.connection()
                if (connection == null) {
                    ConnectionResult = "Check Your Internet Access!"
                } else {
                    val query = "Select * from [ELITE].[dbo].[Covid.Empleados] where IDempleado 16523"
                    val statement = connection!!.createStatement()
                    val resultSet = statement.executeQuery(query)
                    while (resultSet.next()) {
                        val dataNum: MutableMap<String?, String?> = HashMap()
                        dataNum["IDempleado"] = resultSet.getString("IDempleado")
                        dataNum["Descripcion"] = resultSet.getString("Descripcion")
                        dataNum["Cedula"] = resultSet.getString("Cedula")
                        data.add(dataNum)
                    }
                    ConnectionResult = "Successful!"
                    isSuccess = true
                    connection!!.close()
                }
            } catch (e: Exception) {
                isSuccess = true
                ConnectionResult = e.message
            }
            return data
        }
}
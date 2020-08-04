package com.example.happybirthday

import android.annotation.SuppressLint
import com.unboundid.ldap.sdk.AddRequest
import com.unboundid.ldap.sdk.LDAPConnection
import com.unboundid.ldap.sdk.LDAPConnectionOptions
import com.unboundid.ldap.sdk.LDAPException


class verifica {
    //String address="ldap://server1.mydomain.com" ;
    var address = "LDAP://ELITE.LOCAL/DC=ELITE"
    var port = 389
    var ho = ""
    //String bindDN="CN=name,CN=users,DC=mydomain,DC=com";
    var bindDN = "pastingenieria@ELITE.LOCAL"
    var password = "@Elite202008."
    var login_flag = true
    var c: LDAPConnection? = null
    var addRequest: AddRequest? = null

    @SuppressLint("SimpleDateFormat")
    fun conectacion() {
        try {
            c = LDAPConnection(address, port, bindDN, password)
            c!!.setConnectionName("Por Fin!")
            val con_name: String = c!!.getConnectionName()
            //val time: Long = c!!.getConnectTime()
            //val formatter = SimpleDateFormat("dd-MM-yy HH:mm:ss")
            //val dateString = formatter.format(Date(time))
            ho = "Connected to LDAP server....connection_name=$con_name"
        } catch (e: LDAPException) {
            login_flag = false
            e.printStackTrace()
            ho = "No connection was established"
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (login_flag) {
                c!!.close()
                ho = "Connection Closed successfully"
            }
        }
    }
}
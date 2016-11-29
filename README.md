# cnxLdap
SPRING BOOT + SPRING SECURITY + THYMELEAF

Authentification sur Active Directory Microsoft
===============================================

Dans application.properties :<BR>
ldap.url=ldap://"IP_Active_Directory"/dc="DC",dc="COM"<BR>
ldap.user=CN="User_Admin",OU="OU",....,DC="DC",dc="COM"<BR>
ldap.password="User_Password"

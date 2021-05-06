# MySQL Workbench No User Added (Common Error)
If you want to make use of Intellij's database connection, you will need to connect
to the database user directly, which will require the username and password.
Sometimes when creating a user, the user cannot be seen within the workbench
application. To fix this, after creating the user with an sql query, click the small
plus icon next to the title "MySQL Connections". This will bring up a dialog, within
the dialog provide the connection name, username, and password. The connection name
will be the same as the username. Once done, the user connection will be viewable from
MySQL Workbench now. From this point enter the same data into Intellij. The url will
be written in the form of "jdbc:mysql://{ip-address}" where the ip address is found
beneath the connection name in Workbench.
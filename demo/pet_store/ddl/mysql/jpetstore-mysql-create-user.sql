-- Create a new user, grant her rights, and set her password.
grant select, insert, update, delete
on jpetstore.*
to jpetstore@localhost identified by 'nutz';
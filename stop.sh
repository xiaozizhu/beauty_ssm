#/bin/sh
pid=ps aux | grep jetty | grep -v grep | awk '{print $2}'
echo ${pid}
kill -9 ${pid}

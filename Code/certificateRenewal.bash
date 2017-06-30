#!/usr/bin/env bash

/var/www/certbot-auto renew | grep 'No renewals were attempted.'
if [ $? -ne 0 ]; then
    cp "/etc/letsencrypt/live/${VIP_WEB_DOMAIN}/*" ${SERVERJS_LOCATION}
    #restart the server
    kill $(pidof nodejs)
    cd ${SERVERJS_LOCATION}
    forever start ${SERVERJS_LOCATION}
fi
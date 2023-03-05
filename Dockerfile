FROM airhacks/glassfish
COPY ./target/ems-users.war ${DEPLOYMENT_DIR}

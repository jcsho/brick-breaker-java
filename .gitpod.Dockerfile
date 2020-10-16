FROM gitpod/workspace-full-vnc:latest

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 11.0.8-open \
             && sdk use java 11.0.8-open"

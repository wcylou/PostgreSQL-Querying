FROM postgres:10

ENV POSTGIS_MAJOR=2.4
ENV POSTGIS_VERSION 2.4.3+dfsg-2.pgdg90+1

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
           postgresql-10-postgis-2.4 \
           postgresql-10-postgis-scripts \
           postgis

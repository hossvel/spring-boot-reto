#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE USER root PASSWORD 'root';
    CREATE DATABASE c7_data OWNER root;
    GRANT ALL PRIVILEGES ON DATABASE c7_data TO root;
EOSQL

SELECT 'CREATE DATABASE hogehoge'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'hogehoge')\gexec
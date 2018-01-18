#!/usr/bin/env bash
#/bin/sh
cd /Users/such/IdeaProjects/beauty_ssm
nohup mvn jetty:run > ./nohup.log 2>&1 &

#!/usr/bin/env bash

adb -s $1 logcat | grep -i "console" > android_browser.log &
echo $!

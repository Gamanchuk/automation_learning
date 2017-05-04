#!/usr/bin/env bash

adb logcat | grep -i "console" > android_browser.log &
echo $!

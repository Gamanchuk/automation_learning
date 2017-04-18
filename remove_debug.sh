#!/bin/bash

# This script singly removes @debug annotation from all feature file
# Run it with as Bash script or just copy-paste it into the shell

find src/test/resources/features/ -type f -print0 | xargs -0 sed -i '/\@debug/ s/@debug//'
#!/usr/bin/env bash

function run {
    echo "Running Suite $1"
    mvn clean install -P $1,$DEVICE,$ENV,$SITE,$PROJECT_TRACKING_PARAM,$VERBOSE_LOGGING_PARAM
}

#DEVICE="device-GalaxyS6"
#ENV="env-eugene-local"
#SITE="site-pepboys-stage"
#SHA="origin/testCase_refactoring"
#SUITES="suite-pepboys-debug"
#PROJECT_TRACKING="false"
#VERBOSE_LOGGING="false"

echo
echo "**********"
echo "Build info:"
echo "Device name: "$DEVICE
echo "Environment: "$ENV
echo "Project Tracking: "$PROJECT_TRACKING
echo "Project Tracking: "$VERBOSE_LOGGING
echo "Site name: "$SITE
echo "Suite name: "$SUITES
echo "Branch name: "$SHA
echo "**********"
echo

if [ -e /Users/jenkins/.bash_profile ] ; then source /Users/jenkins/.bash_profile ; fi

if [ $PROJECT_TRACKING = "true" ]; then
    PROJECT_TRACKING_PARAM="Project-Tracking"
fi

if [ $VERBOSE_LOGGING = "true" ]; then
    VERBOSE_LOGGING_PARAM="Verbose-Logging"
fi

# Check, that we do not have to run full test run
echo $SUITES | grep "suite-pepboys-full" > /dev/null
if [ $? -eq 0 ]; then
    # Read pom.xml and get all suites
    cat pom.xml |  grep -oP "<id>\Ksuite-.*(?=</id)" | while read suite ; do
       run $suite
    done
 else
    # parse SUITES parameter and run described suites
    IFS=',' read -ra SUITE <<< "$SUITES"
    for suite in "${SUITE[@]}"; do
        run $suite
    done
fi



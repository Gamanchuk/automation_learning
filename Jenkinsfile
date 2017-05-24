def branches = [:]
def devices = "${DEVICES}".split(",")

for (int i = 0; i < devices.length; i++) {
  def device = devices[i]
  echo device
  branches[device] = {
	stage(device) {
	  build job: "device_run", parameters: [
	  	[$class: 'StringParameterValue', name: 'DEVICE', value: device],
	  	[$class: 'StringParameterValue', name: 'ENV', value: ${ENV}],
	  	[$class: 'StringParameterValue', name: 'SITE', value: ${SITE}],
	  	[$class: 'com.cwctravel.hudson.plugins.extended_choice_parameter.ExtendedChoiceParameterValue', name: 'SUITES', value: ${DEVICE}],
	  	[$class: 'BooleanParameterValue', name: 'PROJECT_TRACKING', value: ${PROJECT_TRACKING}],
	  	[$class: 'GitParameterValue', name: 'SHA', value: ${SHA}]
	  ]
	}
  }
}
parallel branches

## Installation of command line appium tool last version

## System requirements
	
	1.1 Requaire Node 4 or above
	1.2 Xcode 8 and iOS 10
	
## External dependencies
	
	brew install ideviceinstaller 
	brew install carthage 
	npm install -g ios-deploy 
	npm install -g deviceconsole 
	gem install xcpretty 
	brew install libimobiledevice --HEAD (for iOS 10) 
	brew install libimobiledevice (for iOS 9) 
	
## WebDriverAgent configuration
	
	3.1 Go to folder WebDriverAgent: /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/
	3.2 mkdir -p Resources/WebDriverAgent.bundle
	3.3 sh ./Scripts/bootstrap.sh -d
	3.4 Open WebDriverAgent.xcodeproj (double click or in terminal: open WebDriverAgent.xcodeproj)
	3.5 Signing project 
	3.6 build project 
	
	
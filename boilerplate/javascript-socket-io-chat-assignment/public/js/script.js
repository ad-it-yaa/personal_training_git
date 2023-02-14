function sendMessage() {
}

function joinChannel() {
}

function leaveChannel() {
}

function onWelcomeMessageReceived() {
}

function onNewMessageReceived() {
}

function onAddedToNewChannelReceived() {
}

function onRemovedFromChannelReceived() {
}

module.exports = {
	sendMessage,
	joinChannel,
	leaveChannel,
	onWelcomeMessageReceived,
	onNewMessageReceived,
	onAddedToNewChannelReceived,
	onRemovedFromChannelReceived
};

// You will get error - Uncaught ReferenceError: module is not defined
// while running this script on browser which you shall ignore
// as this is required for testing purposes and shall not hinder
// it's normal execution


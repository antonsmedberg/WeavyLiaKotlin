package com.example.weavyliakotlin

import androidx.annotation.NonNull
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers.data
import org.json.JSONObject

class ChatManager {
    companion object {
        fun connectToChat(listener: ChatConnectionListener) {
            // Connection to the chat server
            // Implement the actual connection logic here
        }
    }
}

interface ChatConnectionListener {
    fun onChatConnected()
    fun onChatDisconnected()
    fun onConnectionFailed()
}

// Registering a User
fun registerUser(userId: String, callback: (isSuccess: Boolean, throwable: Throwable?, data: JSONObject?) -> Unit) {
    // Implement user registration logic here
}

// Send a text message
fun sendTextMessage(toJid: String, text: String, listener: SendMessageListener) {
    // Implement send text message logic here
}

interface SendMessageListener {
    fun onResponse(isSuccess: Boolean, chatMessage: ChatMessage?)
}

// ChatMessageReceived callback
interface ChatMessageReceivedListener {
    fun onChatMessageReceived(@NonNull chatMessage: ChatMessage)
}

data class ChatMessage(val content: String) // Replace with your actual ChatMessage class

// Usage example
val chatConnectionListener = object : ChatConnectionListener {
    override fun onChatConnected() {
        println("Chat connected")
        // Write your success code here navigate to profile or start chat with friends
    }

    override fun onChatDisconnected() {
        println("Chat disconnected")
        // disconnect from chat
    }

    override fun onConnectionFailed() {
        println("Connection failed")
        // Connection Not authorized
    }
}
// Args Example:
// USER_IDENTIFIER = Type = String
// USER_NAME =  Type = String
// USER_TYPE =  Type = String
// CALLBACK  =  Type = String  Weavy

// FORCE_LOGIN =  Type = boolean
// If FORCE_REGISTER is false and it reached the maximum no of multi-sessions then registration will not succeed
// it will throw a 405 exception, Either FORCE_REGISTER should be true or one of the existing session need to be logged out to continue registration.

ChatManager.connectToChat(chatConnectionListener)

registerUser("USER_ID") { isSuccess, throwable, data ->
    if (isSuccess) {
        val isNewUser = data.["isNewUser"] as Boolean
        val response = CMSObjectIdentifiers.data.get("response data") as JSONObject
        // Get Username and password from the object
    } else {
        // Registration failed
    }
}

val sendMessageListener = object : SendMessageListener {
    override fun onResponse(isSuccess: Boolean, chatMessage: ChatMessage?) {
        // you will get the message sent success response
    }
}

sendTextMessage("TO_JID", "TEXT", listener = sendMessageListener)

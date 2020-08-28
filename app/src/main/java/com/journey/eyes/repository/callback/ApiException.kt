package com.journey.eyes.repository.callback

class ApiException(var code: Int, override var message: String) : RuntimeException()
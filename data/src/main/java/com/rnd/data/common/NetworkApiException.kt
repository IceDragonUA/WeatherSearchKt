package com.rnd.data.common

import com.rnd.data.datasource.remote.model.RemoteResponseError
import java.io.IOException

class NetworkApiException(val error: RemoteResponseError?) : IOException()
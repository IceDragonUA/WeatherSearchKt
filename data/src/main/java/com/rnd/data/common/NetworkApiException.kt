package com.rnd.data.common

import com.rnd.data.datasource.model.RemoteResponseError
import java.io.IOException

class NetworkApiException(val error: RemoteResponseError?) : IOException()
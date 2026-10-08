package com.example.foroom.Helper

import com.example.foroom.data.Constants.SUFFIX_MOD

fun uniqueSuffix() = " ${System.currentTimeMillis() % SUFFIX_MOD}"
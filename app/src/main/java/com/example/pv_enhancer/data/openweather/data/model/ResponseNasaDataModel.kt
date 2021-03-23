package com.example.pv_enhancer.data.openweather.data.model

data class ResponseNasaDataModel(
    val featureIrradiances: List<FeatureIrradiances>,
    val header: Header,
    val messages: List<Any>,
    val outputs: Outputs,
    val parameterInformation: ParameterInformation,
    val time: List<List<Any>>,
    val type: String
)

data class FeatureIrradiances(
    val geometry: Geometry,
    val properties: Properties,
    val type: String
)

data class Header(
    val api_version: String,
    val fillValue: String,
    val range: String,
    val title: String
)

data class Outputs(
    val json: String
)

data class ParameterInformation(
    val ALLSKY_SFC_SW_DWN: ALLSKYSFCSWDWNX,
    val DIFF: DIFFX,
    val DNR: DNRX
)

data class Geometry(
    val coordinates: List<Double>,
    val type: String
)

data class Properties(
    val parameter: Parameter
)

data class Parameter(
    val ALLSKY_SFC_SW_DWN: ALLSKYSFCSWDWN,
    val DIFF: DIFF,
    val DNR: DNR
)

data class ALLSKYSFCSWDWN(
    val `1`: Double,
    val `10`: Double,
    val `11`: Double,
    val `12`: Double,
    val `13`: Double,
    val `2`: Double,
    val `3`: Double,
    val `4`: Double,
    val `5`: Double,
    val `6`: Double,
    val `7`: Double,
    val `8`: Double,
    val `9`: Double
)

data class DIFF(
    val `1`: Double,
    val `10`: Double,
    val `11`: Double,
    val `12`: Double,
    val `13`: Double,
    val `2`: Double,
    val `3`: Double,
    val `4`: Double,
    val `5`: Double,
    val `6`: Double,
    val `7`: Double,
    val `8`: Double,
    val `9`: Double
)

data class DNR(
    val `1`: Double,
    val `10`: Double,
    val `11`: Double,
    val `12`: Double,
    val `13`: Double,
    val `2`: Double,
    val `3`: Double,
    val `4`: Double,
    val `5`: Double,
    val `6`: Double,
    val `7`: Double,
    val `8`: Double,
    val `9`: Double
)

data class ALLSKYSFCSWDWNX(
    val longname: String,
    val units: String
)

data class DIFFX(
    val longname: String,
    val units: String
)

data class DNRX(
    val longname: String,
    val units: String
)
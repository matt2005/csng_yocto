SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "OpenAuto" 
LICENSE = "GPL-3.0" 
LIC_FILES_CHKSUM = "file://../git/Readme.md;md5=32ef6748de2f0d2a39f812e1f6a0cb78"
SRC_URI = "git://github.com/opencardev/openauto.git;protocol=https;branch=crankshaft-ng"
SRCREV = "crankshaft-ng"
DEPENDS += "aasdk pulseaudio gpsd taglib util-linux"
inherit cmake
EXTRA_OECMAKE += '-DCMAKE_BUILD_TYPE=Release -DRPI3_BUILD=TRUE -DAASDK_INCLUDE_DIRS="${WORKDIR}/../aasdk/include" -DAASDK_LIBRARIES="${D}${bindir}/libaasdk.so" -DAASDK_PROTO_INCLUDE_DIRS="${WORKDIR}/../aasdk" -DAASDK_PROTO_LIBRARIES="${D}${bindir}/libaasdk_proto.so" ../git'

 
# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/openauto"

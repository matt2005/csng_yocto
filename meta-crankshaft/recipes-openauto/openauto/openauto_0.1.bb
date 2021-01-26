SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "OpenAuto" 
LICENSE = "GPL-3.0" 
LIC_FILES_CHKSUM = "file://../git/Readme.md;md5=32ef6748de2f0d2a39f812e1f6a0cb78"
SRC_URI = "git://github.com/opencardev/openauto.git;protocol=https;branch=crankshaft-ng"
SRCREV = "crankshaft-ng"
DEPENDS += "aasdk pulseaudio libgps taglib util-linux-libblkid-dev"
inherit cmake
EXTRA_OECMAKE += '-DCMAKE_BUILD_TYPE=Release -DRPI3_BUILD=TRUE -DAASDK_INCLUDE_DIRS="${WORKDIR}/../aasdk/include" -DAASDK_LIBRARIES="${D}${bindir}/libaasdk.so" -DAASDK_PROTO_INCLUDE_DIRS="${WORKDIR}/../aasdk" -DAASDK_PROTO_LIBRARIES="${D}${bindir}/libaasdk_proto.so" ../git'
}
 
# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/openauto"

# this command will be run to compile your source code. it assumes you are in the
# directory indicated by S. i'm just going to use make and rely on my Makefile
#do_compile () {
#  cmake -DCMAKE_BUILD_TYPE=Release ../git
#  make -j2
#}
 
# this will copy the compiled file and place it in ${bindir}, which is /usr/bin
#do_install () {
#  install -d ${D}${libdir}
#  install -m 0755 libaasdk.so ${D}${libdir}
#  install -m 0755 libaasdk_proto.so ${D}${libdir}
#}

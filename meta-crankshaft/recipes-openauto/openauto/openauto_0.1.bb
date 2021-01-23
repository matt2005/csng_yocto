SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "OpenAuto" 
LICENSE = "GPL-3.0" 
SRC_URI = "gitsm://github.com/opencardev/openauto.git;protocol=https"
SRCREV = "crankshaft-ng"
DEPENDS += "aasdk"

# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/openauto_build"

# this command will be run to compile your source code. it assumes you are in the
# directory indicated by S. i'm just going to use make and rely on my Makefile
do_compile () {
  cmake -DCMAKE_BUILD_TYPE=Release -DRPI3_BUILD=TRUE -DAASDK_INCLUDE_DIRS="${WORKDIR}/aasdk/include" -DAASDK_LIBRARIES="${D}${bindir}/libaasdk.so" -DAASDK_PROTO_INCLUDE_DIRS="${WORKDIR}/aasdk_build" -DAASDK_PROTO_LIBRARIES="${D}${bindir}/libaasdk_proto.so" ../openauto
  make -j2
}
 
# this will copy the compiled file and place it in ${bindir}, which is /usr/bin
do_install () {
  install -d ${D}${bindir}
  install -m 0755 bin/autoap ${D}${bindir}
  install -m 0755 bin/btservice ${D}${bindir}
}
DESCRIPTION = "Crankshaft Helpers"
SECTION = "libs"
LICENSE = "crankshaft"
HOMEPAGE = "http://getcrankshaft.com"

DEPENDS = "crankshaft"
RDEPENDS_${PN} += "bash"
S="${WORKDIR}"

PR = "r0"
LIC_FILES_CHKSUM = "file://crankshaft;md5=26cb4d70aa81284b5830b20c19d72234"
SRC_URI= "https://raw.githubusercontent.com/opencardev/prebuilts/master/csmt/crankshaft;name=crankshaft \
https://raw.githubusercontent.com/opencardev/prebuilts/master/openauto/autoapp_helper;name=autoapp_helper \
"
SRC_URI[crankshaft.md5sum] = "26cb4d70aa81284b5830b20c19d72234"
SRC_URI[autoapp_helper.md5sum] = "77c80ce324682557acf6e648cfbc4535"

do_install() {
	install -d ${D}/usr/local/bin
	install -m 0755 ${S}/crankshaft ${D}/usr/local/bin
	install -m 0755 ${S}/autoapp_helper ${D}/usr/local/bin
}

FILES_${PN} += "\
	/usr/local/bin \
"

DESCRIPTION = "Crankshaft Helpers"
SECTION = "libs"
HOMEPAGE = "http://getcrankshaft.com"

DEPENDS = "crankshaft"
RDEPENDS_${PN} += "bash zip"
S="${WORKDIR}"

PR = "r1"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://../git/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
SRC_URI= "https://raw.githubusercontent.com/opencardev/prebuilts/master/csmt/crankshaft;name=crankshaft \
https://raw.githubusercontent.com/opencardev/prebuilts/master/openauto/autoapp_helper;name=autoapp_helper \
"
SRC_URI[crankshaft.sha256sum] = "c37bce42dc5c6c28b0ea91eff3881d09a2a675902348b2cb1792e2d3c785b30a"
SRC_URI[autoapp_helper.sha256sum] = "d2de76ac0afa3a5bd8d9202f30d76af6a84fe70aa63d55a1cef049db0bfefe14"

do_install() {
	install -d ${D}/usr/local/bin
	install -m 0755 ${S}/crankshaft ${D}/usr/local/bin
	install -m 0755 ${S}/autoapp_helper ${D}/usr/local/bin
}

FILES_${PN} += "\
	/usr/local/bin \
"

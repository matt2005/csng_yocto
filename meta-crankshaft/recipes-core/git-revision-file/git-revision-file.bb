SUMMARY = "Place a git revision file in the sysroot"

inherit image-buildinfo

REVISION_INFO_FILE = "build-layers-git-revisions"
S = "${WORKDIR}"

pyhton do_configure() {
    with open(d.expand(${S}/${REVISION_INFO_FILE}) as file:
        file.writelines(get_layer_revs(d))
}

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${S}/${REVISION_INFO_FILE} ${D}${sysconfdir}
}

FILES_${PN} = ${sysconfdir}
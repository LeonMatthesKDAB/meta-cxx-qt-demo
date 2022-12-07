inherit cmake_qt5 systemd

DEPENDS+="qtbase qtdeclarative qtquickcontrols2 demo-threading-rustlib"
RDEPENDS_${PN} = "qtquickcontrols2 \
		qtgraphicaleffects-qmlplugins \
		ttf-opensans \
		"

SUMMARY="The Cxx-Qt Threading Demo"
LICENSE="MIT"
LIC_FILES_CHKSUM = " \
    file://LICENSES/MIT.txt;md5=7dda4e90ded66ab88b86f76169f28663 \
"

SRC_URI="gitsm://github.com/LeonMatthesKDAB/cxx-qt.git;protocol=https;nobranch=1;branch=yocto"
SRCREV="5e384c1a2cd4962e7551983ca1461b3a5eef83ca"
S = "${WORKDIR}/git"

OECMAKE_SOURCEPATH="${S}/examples/demo_threading/"
SYSTEMD_SERVICE_${PN} = "demo-threading.service demo-threading-sensors.service"

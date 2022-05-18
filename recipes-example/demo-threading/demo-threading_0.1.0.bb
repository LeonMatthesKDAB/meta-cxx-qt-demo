inherit cmake_qt5

DEPENDS+="qtbase qtdeclarative qtquickcontrols2 demo-threading-rustlib"

SUMMARY="The Cxx-Qt Threading Demo"
LICENSE="MIT"
LIC_FILES_CHKSUM = " \
    file://LICENSES/MIT.txt;md5=7dda4e90ded66ab88b86f76169f28663 \
"

SRC_URI="gitsm://github.com/LeonMatthesKDAB/cxx-qt.git;protocol=https;nobranch=1;branch=yocto"
SRCREV="9118d3fcdd838c71cde92cb0d5043b010b9db517"
S = "${WORKDIR}/git"

OECMAKE_SOURCEPATH="${S}/examples/demo_threading/"

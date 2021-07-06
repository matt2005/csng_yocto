```bash 
mkdir -p ~/yocto
cd ~/yocto
sudo chmod 777 ~/yocto
repo init -u https://github.com/matt2005/yocto_manifests.git -b main
repo sync
mkdir -p ~/yocto/rpi/build/conf
cp ~/yocto/poky-dunfell/meta-crankshaft/meta-crankshaft/conf/local.conf.sample ~/yocto/rpi/build/conf/local.conf
cp ~/yocto/poky-dunfell/meta-crankshaft/meta-crankshaft/conf/bblayers.conf.sample ~/yocto/rpi/build/conf/bblayers.conf
export MACHINE=raspberrypi3
mkdir -p ~/yocto/sstate-cache
mkdir -p ~/yocto/download
export SSTATE_DIR = "$(pwd)/yocto/sstate-cache"
export DL_DIR = "$(pwd)/yocto/download"
source ~/yocto/poky-dunfell/oe-init-build-env ~/yocto/rpi/build
bitbake crankshaft-image
```
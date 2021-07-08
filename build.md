```bash 
mkdir -p ~/yocto
cd ~/yocto
sudo chmod 777 ~/yocto
repo init -u https://github.com/matt2005/yocto_manifests.git -b main -m csngx64.xml
repo sync
mkdir -p ~/yocto/rpi/build/conf
cp ~/yocto/poky-dunfell/meta-crankshaft/meta-crankshaft/conf/local.conf.sample ~/yocto/rpi/build/conf/local.conf
cp ~/yocto/poky-dunfell/meta-crankshaft/meta-crankshaft/conf/bblayers.conf.sample ~/yocto/rpi/build/conf/bblayers.conf
export MACHINE=raspberrypi4-64
mkdir -p ~/yocto/sstate-cache
mkdir -p ~/yocto/download
export SSTATE_DIR = "$(pwd)/sstate-cache"
export DL_DIR = "$(pwd)/download"
source ~/yocto/poky-dunfell/oe-init-build-env ~/yocto/rpi/build
bitbake crankshaft-image --runall=fetch
bitbake crankshaft-image
```

if Vagrant::VERSION < "2.0.0"
  $stderr.puts "Must redirect to new repository for old Vagrant versions"
  Vagrant::DEFAULT_SERVER_URL.replace('https://vagrantcloud.com')
end

disk1 = './elasticDisk.vdi'
disk2 = './kibanaDisk.vdi'
disk3 = './logstashDisk.vdi'

Vagrant.configure("2") do |config|
  config.vm.box = "centos/7"
  config.vm.box_check_update = false
  config.vm.synced_folder "shared/", "/shared", create: true, group: "vagrant"

  config.vm.define :server01 do |server01|
    server01.vm.network :private_network, ip: "192.168.50.10"
    server01.vm.hostname = "server01.challenge.lab"
    server01.vm.provision :shell, path: "provision-server01", args: ENV['ARGS']
    server01.vm.provider "virtualbox" do |s01|
      s01.customize ["modifyvm", :id, "--cpus", "1"]
      s01.name = "server01"
      s01.memory = 1024
      unless File.exist?(disk1)
      s01.customize ['createhd', '--filename', disk1, '--variant', 'Fixed', '--size', 6 * 1024]
      end
      s01.customize ['storageattach', :id,  '--storagectl', 'IDE', '--port', 1, '--device', 0, '--type', 'hdd', '--medium', disk1]
    end
  end

  config.vm.define :server02 do |server02|
    server02.vm.network :private_network, ip: "192.168.50.20"
    server02.vm.hostname = "server02.challenge.lab"
    server02.vm.provision :shell, path: "provision-server02", args: ENV['ARGS']
    server02.vm.provider "virtualbox" do |s02|
      s02.customize ["modifyvm", :id, "--cpus", "1"]
      s02.name = "server02"
      unless File.exist?(disk2)
      s02.customize ['createhd', '--filename', disk2, '--variant', 'Fixed', '--size', 6 * 1024]
      end
      s02.customize ['storageattach', :id,  '--storagectl', 'IDE', '--port', 1, '--device', 0, '--type', 'hdd', '--medium', disk2]
    end
  end

  config.vm.define :server03 do |server03|
    server03.vm.network :private_network, ip: "192.168.50.30"
    server03.vm.hostname = "server03.challenge.lab"
    server03.vm.provision :shell, path: "provision-server03", args: ENV['ARGS']
    server03.vm.provider "virtualbox" do |s03|
      s03.customize ["modifyvm", :id, "--cpus", "1"]
      s03.name = "server03"
      unless File.exist?(disk3)
      s03.customize ['createhd', '--filename', disk3, '--variant', 'Fixed', '--size', 6 * 1024]
      end
      s03.customize ['storageattach', :id,  '--storagectl', 'IDE', '--port', 1, '--device', 0, '--type', 'hdd', '--medium', disk3]
    end
  end

  config.vm.define :server04 do |server04|
    server04.vm.network :private_network, ip: "192.168.50.40"
    server04.vm.hostname = "server04.challenge.lab"
    server04.vm.provision :shell, path: "provision-server04", args: ENV['ARGS']
    server04.vm.provider "virtualbox" do |s04|
      s04.customize ["modifyvm", :id, "--cpus", "1"]
      s04.name = "server04"
    end
  end

end

prunsrv.exe //IS//Procrun-SpringBootWindowService --DisplayName="Procrun-SpringBootWindowService" --Description="Procrun-SpringBootWindowService" ^
							--Startup=auto --Install=%CD%\prunsrv.exe --Jvm=auto --Classpath=%CD%\..\target\springbootwindowsservice-0.0.1.jar ^
                            --StartMode=jvm --StartClass=com.javasampleapproach.windowsservice.Bootstrap --StartMethod=start --StartParams=start ^
							--StopMode=jvm --StopClass=com.javasampleapproach.windowsservice.Bootstrap --StopMethod=stop --StopParams=stop ^
							--StdOutput=auto --StdError=auto --LogPath=%CD% --LogLevel=Debug ^
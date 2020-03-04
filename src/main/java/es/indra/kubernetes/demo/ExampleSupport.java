/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package es.indra.kubernetes.demo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Base Action class for the Tutorial package.
 */
public class ExampleSupport extends ActionSupport {

  private static final long serialVersionUID = 675161494634923438L;

  public String getIpAddress() {

    String ipAddress = "";

    try {

      Enumeration<NetworkInterface> Interfaces = NetworkInterface.getNetworkInterfaces();
      while (Interfaces.hasMoreElements()) {
        NetworkInterface Interface = Interfaces.nextElement();
        Enumeration<InetAddress> Addresses = Interface.getInetAddresses();
        while (Addresses.hasMoreElements()) {
          InetAddress Address = Addresses.nextElement();
          if (Address.getHostAddress().startsWith("127")) {
            break;
          } else if (Address.getHostAddress().startsWith("0:")) {
            break;
          }
          ipAddress += Address.getHostAddress() + " ";
        }
      }

      return ipAddress;

    } catch (SocketException e) {

      e.printStackTrace();

    }

    return "";
  }
}

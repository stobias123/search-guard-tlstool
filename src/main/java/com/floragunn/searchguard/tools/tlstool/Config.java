package com.floragunn.searchguard.tools.tlstool;

import java.util.List;

public class Config {
	
	public static final String DEFAULT_OID = "1.2.3.4.5.5";
	
	private Ca ca;
	private List<Node> nodes;
	private List<Client> clients;
	private String target;
	private String elasticSearchTarget;
	private Defaults defaults;
	
	public String getElasticSearchTarget() {
		return elasticSearchTarget;
	}


	public void setElasticSearchTarget(String elasticSearchTarget) {
		this.elasticSearchTarget = elasticSearchTarget;
	}

	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}

	public Ca getCa() {
		return ca;
	}


	public void setCa(Ca ca) {
		this.ca = ca;
	}


	public List<Node> getNodes() {
		return nodes;
	}


	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}



	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public Defaults getDefaults() {
		return defaults;
	}


	public void setDefaults(Defaults defaults) {
		this.defaults = defaults;
	}
	
	public void applyDefaults() {
		if (defaults == null) {
			defaults = new Defaults();
		}
		
		if (ca != null) {
			ca.applyDefaults(defaults);
		}
		
		if (nodes != null) {
			for (Node node : nodes) {
				node.applyDefaults(defaults);
			}
		}
		
		if (clients != null) {
			for (Client client : clients) {
				client.applyDefaults(defaults);
			}
		}
	}
	
	
	public static class Defaults {
		private String pkPassword;
		private int validityDays = 730;
		private int keysize = 2048;
		private String nodeOid = DEFAULT_OID;
		private List<String> nodesDn; 
		private int generatedPasswordLength = 12;
		private boolean httpEnabled;
		
		public String getPkPassword() {
			return pkPassword;
		}
		public void setPkPassword(String pkPassword) {
			this.pkPassword = pkPassword;
		}
		public int getValidityDays() {
			return validityDays;
		}
		public void setValidityDays(int validityDays) {
			this.validityDays = validityDays;
		}
		public int getKeysize() {
			return keysize;
		}
		public void setKeysize(int keysize) {
			this.keysize = keysize;
		}
		public String getNodeOid() {
			return nodeOid;
		}
		public void setNodeOid(String nodeOid) {
			this.nodeOid = nodeOid;
		}
		public int getGeneratedPasswordLength() {
			return generatedPasswordLength;
		}
		public void setGeneratedPasswordLength(int generatedPasswordLength) {
			this.generatedPasswordLength = generatedPasswordLength;
		}
		public List<String> getNodesDn() {
			return nodesDn;
		}
		public void setNodesDn(List<String> nodesDn) {
			this.nodesDn = nodesDn;
		}
		public boolean isHttpEnabled() {
			return httpEnabled;
		}
		public void setHttpEnabled(boolean httpEnabled) {
			this.httpEnabled = httpEnabled;
		}
	}


	public static class Ca {
	
		private Certificate root;
		private Certificate intermediate;
		
		public Certificate getRoot() {
			return root;
		}

		public void setRoot(Certificate root) {
			this.root = root;
		}

		public Certificate getIntermediate() {
			return intermediate;
		}

		public void setIntermediate(Certificate intermediate) {
			this.intermediate = intermediate;
		}
		

		public void applyDefaults(Defaults defaults) {
			if (root != null) {
				root.applyDefaults(defaults);
			}
			
			if (intermediate != null) {
				intermediate.applyDefaults(defaults);
			}
			
		}

		public static class Certificate {
			private Integer keysize = null;
			private String dn;
			private Integer validityDays = null;
			private List<String> crlDistributionPoints;
			private String file;
			private String pkPassword;
			
			public String getPkPassword() {
				return pkPassword;
			}

			public void setPkPassword(String password) {
				this.pkPassword = password;
			}
			public Integer getKeysize() {
				return keysize;
			}
			public void setKeysize(Integer keysize) {
				this.keysize = keysize;
			}
			public String getDn() {
				return dn;
			}
			public void setDn(String dn) {
				this.dn = dn;
			}
			public Integer getValidityDays() {
				return validityDays;
			}
			public void setValidityDays(Integer validityDays) {
				this.validityDays = validityDays;
			}
	
			public List<String> getCrlDistributionPoints() {
				return crlDistributionPoints;
			}
			public void setCrlDistributionPoints(List<String> crlDistributionPoints) {
				this.crlDistributionPoints = crlDistributionPoints;
			}
			public String getFile() {
				return file;
			}
			public void setFile(String file) {
				this.file = file;
			}
			
			public void applyDefaults(Defaults defaults) {
				if (keysize == null) {
					keysize = defaults.getKeysize();
				}
				
				if (validityDays == null) {
					validityDays = defaults.getValidityDays();
				}
				
				if (pkPassword == null) {
					pkPassword = defaults.getPkPassword();
				}
				
			}
		}
	}
	
	
	
	public static class Node {
		private String name;
		private String dn;
		private List<String> dns;
		private List<String> ip;
		private List<String> oid;
		private Integer keysize;
		private String pkPassword;
		private Integer validityDays;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getDn() {
			return dn;
		}
		public void setDn(String dn) {
			this.dn = dn;
		}
		public List<String> getDns() {
			return dns;
		}
		public void setDns(List<String> dns) {
			this.dns = dns;
		}
		public List<String> getIp() {
			return ip;
		}
		public void setIp(List<String> ip) {
			this.ip = ip;
		}
		public List<String> getOid() {
			return oid;
		}
		public void setOid(List<String> oid) {
			this.oid = oid;
		}
		public Integer getKeysize() {
			return keysize;
		}
		public void setKeysize(Integer keysize) {
			this.keysize = keysize;
		}

		public String getPkPassword() {
			return pkPassword;
		}

		public void setPkPassword(String pkPassword) {
			this.pkPassword = pkPassword;
		}
		
		public Integer getValidityDays() {
			return validityDays;
		}

		public void setValidityDays(Integer validityDays) {
			this.validityDays = validityDays;
		}
		
		public void applyDefaults(Defaults defaults) {
			if (keysize == null) {
				keysize = defaults.getKeysize();
			}
			
			if (pkPassword == null) {
				pkPassword = defaults.getPkPassword();
			}
			
			if (validityDays == null) {
				validityDays = defaults.getValidityDays();
			}
		}
		
	}
	
	public static class Client {
		private String name;
		private String dn;
		private Integer keysize;
		private String pkPassword;
		private boolean admin;
		private Integer validityDays;

		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
		public String getDn() {
			return dn;
		}
		public void setDn(String dn) {
			this.dn = dn;
		}
		public Integer getKeysize() {
			return keysize;
		}
		public void setKeysize(Integer keysize) {
			this.keysize = keysize;
		}

		public String getPkPassword() {
			return pkPassword;
		}

		public void setPkPassword(String pkPassword) {
			this.pkPassword = pkPassword;
		}
		
		public boolean isAdmin() {
			return admin;
		}

		public void setAdmin(boolean admin) {
			this.admin = admin;
		}

		public Integer getValidityDays() {
			return validityDays;
		}

		public void setValidityDays(Integer validityDays) {
			this.validityDays = validityDays;
		}
		
		public void applyDefaults(Defaults defaults) {
			if (keysize == null) {
				keysize = defaults.getKeysize();
			}
			
			if (pkPassword == null) {
				pkPassword = defaults.getPkPassword();
			}		
			
			if (validityDays == null) {
				validityDays = defaults.getValidityDays();
			}
		}


	}




}
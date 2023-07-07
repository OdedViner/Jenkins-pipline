variable "REGION" {
  default = "us-east-1"
}

variable "ZONE1" {
  default = "us-east-1c"
}

variable "web_name" {
  default = "web_server"
}

variable "AMIS" {
  type = map(any)
  default = {
    us-east-1 = "ami-026ebd4cfe2c043b2"
    us-east-2 = "ami-053b0d53c279acc90"
  }
}


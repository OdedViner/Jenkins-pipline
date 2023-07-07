resource "aws_instance" "web-server" {
  ami                    = var.AMIS[var.REGION]
  instance_type          = "t2.micro"
  availability_zone      = var.ZONE1
  key_name               = "vprofile-ci-key"
  vpc_security_group_ids = ["sg-0176ab700b37d1b4c"]
  tags = {
    Name = var.web_name
  }
}

output "PublicIP" {
  value = aws_instance.web-server.public_ip
}

output "PrivateIP" {
  value = aws_instance.web-server.private_ip
}
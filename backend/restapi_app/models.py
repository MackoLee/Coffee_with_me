from django.db import models

# Create your models here.
class Users(models.Model):
    name = models.CharField(max_length=50)
    age = models.IntegerField()
    description = models.TextField(null=True)

class Stores(models.Model):
    name = models.CharField(max_length=50)
    address = models.TextField()
    address_en = models.TextField()
    post_num = models.CharField(max_length=10)
    Latitude = models.FloatField()
    longitude = models.FloatField()
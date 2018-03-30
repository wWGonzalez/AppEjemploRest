from django.db import models

# Create your models here.

class Persona(models.Model):
	dpi = models.CharField(primary_key=True,max_length=15)
	apellido = models.CharField(max_length=25)
	nombre = models.CharField(max_length=25)

	def __str__(self):
		return self.nombre
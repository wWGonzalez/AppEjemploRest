from django.db import models

# Create your models here.

class Persona(models.Model):
	dpi = models.CharField(primary_key=True,max_length=15,blank = True)
	nombre = models.CharField(max_length=50,blank = True);
	telefono = models.CharField(max_length=12, blank = True);
	coordenadas = models.CharField(max_length=200, blank= True)
	direccion = models.CharField(max_length=200, blank= True)
	emergencia = models.CharField(max_length=100, blank= True)

	def __str__(self):
		return self.dpi
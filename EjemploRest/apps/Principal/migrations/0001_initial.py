# Generated by Django 2.0.2 on 2018-03-29 04:28

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Persona',
            fields=[
                ('dpi', models.CharField(max_length=15, primary_key=True, serialize=False)),
                ('apellido', models.CharField(max_length=25)),
                ('nombre', models.CharField(max_length=25)),
            ],
        ),
    ]

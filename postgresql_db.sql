PGDMP         '                w            postgres    11.2    11.2      �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    13012    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE postgres;
             postgres    false            �          0    16499    pga_exception 
   TABLE DATA                     pgagent       postgres    false    210   �       �          0    16417    pga_job 
   TABLE DATA                     pgagent       postgres    false    204   �       �          0    16394    pga_jobagent 
   TABLE DATA                     pgagent       postgres    false    200   �       �          0    16405    pga_jobclass 
   TABLE DATA                     pgagent       postgres    false    202   �       �          0    16514 
   pga_joblog 
   TABLE DATA                     pgagent       postgres    false    212   B       �          0    16443    pga_jobstep 
   TABLE DATA                     pgagent       postgres    false    206   \       �          0    16531    pga_jobsteplog 
   TABLE DATA                     pgagent       postgres    false    214   v       �          0    16469    pga_schedule 
   TABLE DATA                     pgagent       postgres    false    208   �       �          0    16593    autos 
   TABLE DATA                     public       postgres    false    217   �       �          0    16619    cars 
   TABLE DATA                     public       postgres    false    221   "       �          0    16693 	   education 
   TABLE DATA                     public       postgres    false    226   �       �          0    16605    persons 
   TABLE DATA                     public       postgres    false    218   8       �          0    16683    profile 
   TABLE DATA                     public       postgres    false    225   i       �          0    16627    registrations 
   TABLE DATA                     public       postgres    false    223   �       �          0    16578    users 
   TABLE DATA                     public       postgres    false    215                      0    0    pga_exception_jexid_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('pgagent.pga_exception_jexid_seq', 1, false);
            pgagent       postgres    false    209                       0    0    pga_job_jobid_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('pgagent.pga_job_jobid_seq', 1, false);
            pgagent       postgres    false    203                       0    0    pga_jobclass_jclid_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('pgagent.pga_jobclass_jclid_seq', 5, true);
            pgagent       postgres    false    201                       0    0    pga_joblog_jlgid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('pgagent.pga_joblog_jlgid_seq', 1, false);
            pgagent       postgres    false    211                       0    0    pga_jobstep_jstid_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('pgagent.pga_jobstep_jstid_seq', 1, false);
            pgagent       postgres    false    205                       0    0    pga_jobsteplog_jslid_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('pgagent.pga_jobsteplog_jslid_seq', 1, false);
            pgagent       postgres    false    213                       0    0    pga_schedule_jscid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('pgagent.pga_schedule_jscid_seq', 1, false);
            pgagent       postgres    false    207                       0    0    cars_sq    SEQUENCE SET     6   SELECT pg_catalog.setval('public.cars_sq', 1, false);
            public       postgres    false    220                       0    0    persons_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.persons_id_seq', 19, true);
            public       postgres    false    227            	           0    0 
   persons_sq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.persons_sq', 1, false);
            public       postgres    false    219            
           0    0    profile_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.profile_id_seq', 1, false);
            public       postgres    false    224                       0    0    registrations_sq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.registrations_sq', 2, true);
            public       postgres    false    222                       0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 12, true);
            public       postgres    false    216            �   
   x���          �   
   x���          �   �   x��A�0�ỿ⻩�㛉2;��u�6�Na$cR*��O��偷��*�;��h�ő��y}�`�f�����.�~�C?7:�.!��KA�g�� e1�c�M�4+0%�!��	��]ʶ�AJ���q�<��U��eMn]������,(      �   �   x��̽
�0 �ݧ�M)�o�Th�@���k���D�����M_�N��ɦm��o08�M�9��2�=�2�]A��R	���.:(�䭋A3A��1���<e��t��i'7�u�~��g}vX�.Z�����u�1�����A&��˲/���      �   
   x���          �   
   x���          �   
   x���          �   
   x���          �   h   x���v
Q���W((M��L�K,-�/V��L�Q��OI��QH���/�Q(-N-��L�Ts�	uV�0�QPw,M�T�E�)@�HӚ˓#M�o���4�j$ 'Pb�      �   h   x���v
Q���W((M��L�KN,*V��L�Q(���Ts�	uV�0�QP�0�4235w�162�026� ��\�D�c1��������2�HX��(�9\\ ��&y      �   �   x�-˱
�0��ݧ�M�P��!t�� ��&�ZRs�{�$|�F����T{���
~}�4Э�M�0TC\�AN@L6�m��~`���2}rGi˕Ǒ���k�_z�*���GR���Wڔ-OĈa�����\��3      �   !  x���OkQ��~��3'̛h̐U kK5ݛ:I�ĈڽN�RJ�vR�!��䏠�1_�o�{ߛI2���1o���9�L�\)���b��V�>o�5>.��v���zF�4ڝn���eĮ׬{�ث�;ۍv�S���Ň��V�"�JF�;��4.o�KZ+��Hw5k��˥�R���#.�!�ԗ�t�ܩ�H�mI�rx$�"��A�H���_5���,[Z�Âv��0T=�W~�� �����Q�%]Y� i�	2}��]B�o�*�a���~�9��y��H}������'LI���Sy�Tb�����=���o	�*�>&uħa�XW����fr2�~1�e4��9&�?���;��z�:c9�b�u� Ar`�B�F�6�PB���u�pZ�ܠ@JE�(�6%94��?+����F6�<�|��Jz�K�K�1�ɏ��w,��.N&8}/���E����O(�Ư���U5;�|�q
}�(sq��c&��/��SLu�ùZ:�b6��'�5xKe03y�����HA*����      �   
   x���          �   z   x���v
Q���W((M��L�+JM�,.)J,���+V��L�Q(H-*�ϋ1���4PU|^inRj��B��O�k������(�����1���i��IM��V��R72�03"s0��� ��>�      �   c   x���v
Q���W((M��L�+-N-*V��L�Q�K�M�QHLO�Ts�	uV�0�QPw��MT�Q06ִ��$� #�a���`4�)?/h�)� .. ?�7�     
package com.example.samreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samreen.R
import com.example.samreen.ui.theme.SamreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SamreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    var expandedSection by remember { mutableStateOf<String?>(null) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFCE4EC), Color(0xFFE1F5FE))
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- Header
            item {
                Image(
                    painter = painterResource(id = R.drawable.samreen),
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .shadow(12.dp, CircleShape, clip = false)
                        .background(Color.White)

                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Samreen Iqbal Chowlkar",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = "Computer Engineer | AI/ML Honors | Android Developer",
                    fontSize = 14.sp,
                    color = Color(0xFF8D6E63)
                )

                Spacer(modifier = Modifier.height(16.dp))

                ContactRow(Icons.Default.Phone, "+91-9321776088")
                ContactRow(Icons.Default.Email, "samreen.chowlkar@aurionpro.com")
                ContactRow(Icons.Default.LocationOn, "Kopar Khairane, Navi Mumbai")

                Spacer(modifier = Modifier.height(18.dp))

                // Objective card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            "Objective",
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            "Passionate Computer Engineer with AI/ML Honors, skilled in Android, web, and cloud development. Dedicated to creating innovative, impactful solutions in dynamic environments.",
                            fontSize = 14.sp,
                            color = Color(0xFF4E342E)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Education Section
            item {
                SectionItem(
                    title = "Education",
                    isExpanded = expandedSection == "Education",
                    onHeaderClick = {
                        expandedSection = if (expandedSection == "Education") null else "Education"
                    }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        listOf(
                            EducationItems(
                                "B.E. Computer Engineering",
                                "A. P. Shah Institute of Technology",
                                "Aug 2022 – May 2025",
                                "CGPA: 9.75/10"
                            ),
                            EducationItems(
                                "Diploma, Computer Engineering",
                                "M. H. Saboo Siddik Polytechnic",
                                "Aug 2019 – May 2022",
                                "%: 88.06"
                            )
                        ).forEach { edu ->
                            Text(
                                edu.degree,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6D9886)
                            )
                            Text(edu.institution, fontSize = 14.sp, color = Color.DarkGray)
                            Text(edu.duration, fontSize = 14.sp, color = Color.Gray)
                            Text(edu.score, fontSize = 14.sp, color = Color(0xFF2E7D32))
                            Divider(color = Color(0xFFBBDEFB), thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))

                        }
                    }
                }
                
            }

            // Internships Section
            item {
                SectionItem(
                    title = "Internships",
                    isExpanded = expandedSection == "Internships",
                    onHeaderClick = {
                        expandedSection =
                            if (expandedSection == "Internships") null else "Internships"
                    }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        InternshipItem(
                            "AICTE Virtual Internship – AWS Data Engineer",
                            "AWS Academy",
                            "2024",
                            "Hands-on experience with AWS data engineering tools and services."
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        InternshipItem(
                            "AICTE Virtual Internship – Zero Trust Cloud Security",
                            "Zscaler Academy",
                            "2024",
                            "Focused on secure cloud access and zero trust principles."
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        InternshipItem(
                            "AICTE Virtual Internship – AI/ML",
                            "Google for Developers",
                            "2024",
                            "Worked on machine learning projects and AI applications."
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        InternshipItem(
                            "AICTE Virtual Internship – Cloud Computing",
                            "AWS Academy",
                            "2023",
                            "Explored AWS cloud services, deployment, and architecture."
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        InternshipItem(
                            "Full Stack Web Development",
                            "TCR Innovation, Navi Mumbai",
                            "2023",
                            "Developed full stack projects with Django, HTML, CSS, and JS."
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        InternshipItem(
                            "AICTE Virtual Internship – Networking Cloud",
                            "Juniper Networks",
                            "2023",
                            "Learned networking fundamentals and cloud network management."
                        )
                    }
                }
                
            }

            // Projects Section
            item {
                SectionItem(
                    title = "Projects",
                    isExpanded = expandedSection == "Projects",
                    onHeaderClick = {
                        expandedSection = if (expandedSection == "Projects") null else "Projects"
                    }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        ProjectItem(
                            "Forensic Insights: An AWS Rekognition Approach for Facial Reconstruction and Identification",
                            "Developing a system using deep learning to generate accurate face sketches and identify suspects, enhancing criminal investigations.",
                            "Python, AWS Cloud"
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        ProjectItem(
                            "SnapSort",
                            "ML-based project using FaceNet and DBSCAN to automatically arrange group photos by similar faces.",
                            "Python, Django"
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        ProjectItem(
                            "Employee Leave Management System",
                            "CMS and role-based website with automated leave approval and department/employee management.",
                            "HTML, CSS, JavaScript, PHP, MySQL"
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        ProjectItem(
                            "Pretty Smiles",
                            "Website for NGO Pretty Smiles with environmental and community development focus, Razorpay integration.",
                            "HTML, CSS, JavaScript, PHP, MySQL, RazorPay"
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        ProjectItem(
                            "BeSpeak - A Place where Memories Shine",
                            "CMS-based platform for Anjuman-I-Islam Trust for online hall and ground booking management.",
                            "HTML, CSS, JavaScript, Node.js, Express.js, MongoDB"
                        )
                    }
                }
                
            }

            // Skills Section
            item {
                SectionItem(
                    title = "Skills",
                    isExpanded = expandedSection == "Skills",
                    onHeaderClick = {
                        expandedSection = if (expandedSection == "Skills") null else "Skills"
                    }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))) {
                                append("Tools: ")
                            }
                            append("GitHub, Android Studio, NetBeans, VS Code, Google Collab, Jupyter Lab, PyCharm")
                        }, fontSize = 14.sp)
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )

                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))) {
                                append("Programming Languages: ")
                            }
                            append("Python, Java, HTML, CSS, JavaScript, C, C++, PHP, Node.js, Django")
                        }, fontSize = 14.sp)
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )

                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))) {
                                append("Database: ")
                            }
                            append("MySQL, Oracle SQL, MongoDB, SQLite")
                        }, fontSize = 14.sp)
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )

                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))) {
                                append("Cloud-Based Technologies: ")
                            }
                            append("AWS, Google Cloud Platform")
                        }, fontSize = 14.sp)
                    }
                }
            }



            // Certifications Section
            item {
                SectionItem(
                    title = "Certifications",
                    isExpanded = expandedSection == "Certifications",
                    onHeaderClick = {
                        expandedSection =
                            if (expandedSection == "Certifications") null else "Certifications"
                    }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        CertificationCategory(
                            "Google Certified:", listOf(
                                "Google Play Academy: Google Play Store Listing Certificate",
                                "Google Analytics: Google Analytics Certification"
                            )
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        CertificationCategory(
                            "Cloud Computing & DevOps:", listOf(
                                "AWS Solution Architecture Job Simulation",
                                "AWS Academy: AWS Academy Cloud Architecting",
                                "AWS Academy: AWS Academy Cloud Foundation",
                                "Udemy: Microsoft Azure - Hands-On Training (AZ-900, AZ-104, and AZ-305)",
                                "TCS Mastercraft™ Academy: DevPlus Scrum Management Edition"
                            )
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        CertificationCategory(
                            "Data Science & Analytics:", listOf(
                                "Udemy: Python Introduction to Data Science and Machine Learning from A to Z",
                                "Cisco: Data Analytics Essentials",
                                "Accenture North America Data Analytics and Visualization Job Simulation"
                            )
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        CertificationCategory(
                            "Cybersecurity-Related:", listOf(
                                "Deloitte Cyber Job Simulation",
                                "Tata Cybersecurity Analyst Job Simulation",
                                "Cisco: Cybersecurity Essentials",
                                "Zscaler Training: Fundamentals of Cybersecurity (EDU-102)"
                            )
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        CertificationCategory(
                            "Programming & Other Certifications:", listOf(
                                "Cisco: Python Essentials 1",
                                "Cisco: Python Essentials 2",
                                "Udemy: Applied Python - Building Projects with Python Programming",
                                "Udemy: Databases with Python - MySQL, SQLite & MongoDB"
                            )
                        )
                    }
                }
                
            }

            // Extracurricular Section
            item {
                SectionItem(
                    title = "Extracurricular",
                    isExpanded = expandedSection == "Extracurricular",
                    onHeaderClick = {
                        expandedSection =
                            if (expandedSection == "Extracurricular") null else "Extracurricular"
                    }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(
                            "Google Developers Students Club",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        )
                        Text(
                            "I am an active participant in the Google Developers Students Club, engaging in various initiatives and projects.",
                            fontSize = 14.sp
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )

                        Text(
                            "Postman Student Expert",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        )
                        Text(
                            "As an active member of the Postman community, I gained extensive knowledge about APIs and their various infrastructures.",
                            fontSize = 14.sp
                        )
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )

                        Text(
                            "Red Dot Foundation (Campus Ambassador)",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        )
                        Text(
                            "At M.H. Saboo Siddik Polytechnic, I promoted awareness programs and initiatives for social causes.",
                            fontSize = 14.sp
                        )
                    }
                }
                
            }


            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

// Helper functions
@Composable
fun CertificationCategory(title: String, items: List<String>) {
    Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
    items.forEach { cert -> Text("• $cert", fontSize = 14.sp) }
    Spacer(Modifier.height(8.dp))
}

@Composable
fun ProjectItem(title: String, desc: String, tools: String) {
    Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
    Text(desc, fontSize = 14.sp)
    Text("Tools & Technologies: $tools", fontSize = 12.sp)
    Spacer(modifier = Modifier.height(8.dp))
}


@Composable
fun SectionItem(
    title: String,
    isExpanded: Boolean,
    onHeaderClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp)
            .clickable { onHeaderClick() },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
    title,
    fontWeight = FontWeight.Bold,
    color = Color.White,
    modifier = Modifier
        .weight(1f)
        .background(
            color = Color(0xFF6D9886),
            shape = RoundedCornerShape(8.dp)
        )
        .padding(horizontal = 8.dp, vertical = 4.dp)
)
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    content()
                }
            }
        }
    }
}

@Composable
fun InternshipItem(title: String, org: String, duration: String, desc: String) {
    Column(modifier = Modifier.padding(vertical = 6.dp)) {
        Text("• $title", fontSize = 14.sp, fontWeight = FontWeight.Bold,  color = Color(0xFF2E7D32))
        Text(org, fontSize = 14.sp, color = Color(0xFF6D4C41))
        Text(duration, fontSize = 12.sp, color = Color.Gray)
        Text(desc, fontSize = 14.sp)
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 14.sp, color = Color(0xFF4E342E))
    }
}
